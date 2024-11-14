import axios from 'axios'
// import { response } from 'express';
import React, { useEffect, useState } from 'react'
import { Fragment} from "react";
import Comment from '../Comment/Comment'

const PostDetails = (props) => {

    const [postDetails, setPostDetails] = useState({});

    useEffect(
        ()=>{
            if(props.id > -1){
                axios.get('http://localhost:8080/api/v1/posts/' + props.id)
                .then(response =>{
                    setPostDetails(response.data)
                })
                .catch(err => console.log(err.message));
            }
        },
        [props.id]
    )

    const space = <Fragment>&nbsp;&nbsp;</Fragment>;

    let postDetailDisplay = null;
    if(props.id > -1){
        // console.log(props.id)
        postDetailDisplay = (
            <div className='PostDetail'>
                <div>
                    Post Details
                </div>
                <h1>{postDetails.title}</h1>
                <div>
                    {postDetails.content}
                    <br/>
                    <div style={{ textAlign:"left" }}>
                        {space} Comments <br/>
                        {postDetails.comments != null ? postDetails.comments.map(comment => {
                            return <Comment name = {comment.name} key={comment.id}/>
                        }): "NO COMMENTS"}
                    </div>
                </div>

            </div>

        );
    }

  return (
    <div>{postDetailDisplay}</div>
  )
}

export default PostDetails