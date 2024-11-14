import axios from 'axios'
// import { response } from 'express';
import React, { useEffect, useState, useContext } from 'react'
import { Fragment} from "react";
import Comment from '../Comment/Comment'
import {SelectIdContext} from '../../context/SelectedId'

const PostDetails = () => {

    const [postDetails, setPostDetails] = useState({});
    const selectedID = useContext(SelectIdContext)


    useEffect(
        ()=>{
            if(selectedID > -1){
                axios.get('http://localhost:8080/api/v1/posts/' + selectedID)
                .then(response =>{
                    setPostDetails(response.data)
                })
                .catch(err => console.log(err.message));
            }
        },
        [selectedID]
    )

    const space = <Fragment>&nbsp;&nbsp;</Fragment>;

    let postDetailDisplay = null;
    if(selectedID > -1){
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