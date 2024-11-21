import React, { Fragment, useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router'
import axios from 'axios';
import Comment from '../Comment/Comment';

export const PostDetails = () => {
    const params = useParams();
    const navigate = useNavigate()
    const [postDetail, setPostDetail] = useState({})

    useEffect(
        ()=>{
        if(params.id){
            axios.get('http://localhost:8080/api/v1/posts/' + params.id + '/comments')
                .then(response => {
                    setPostDetail(response.data)
                })
                .catch(err=>console.log(err.message))
        }
    }, [params.id])

    const deleteButtonClicked = (id) =>{
        axios.delete('http://localhost:8080/api/v1/posts/' + id)
            .then(response=>{
                navigate('/')
            })
            .catch(err=>console.log(err.message))
    }

    const handleNewClick = () =>{
        navigate('/new-post');
    }

    const handleEditClick = () =>{
        navigate('/edit-post/' + params.id);
    }

    const space = <Fragment>&nbsp;&nbsp;</Fragment>

    let postDetailsDisplay = null;

    if(params.id){
        postDetailsDisplay = (
            <div className='PostDetail'>
                <div>
                    Post Details
                </div>
                <h1>{postDetail.title}</h1>
                <div style={{textAlign:"left"}}>
                    {space} Comments <br/>
                    {postDetail.comments != null ? postDetail.comments.map(comment=>{
                        return <Comment name={comment.name} key={comment.id}/>
                    }): null}
                    
                </div>
                <input 
                    type='button'
                    value="Delete"
                    onClick={()=>{deleteButtonClicked(params.id)}}
                />
                <input
                    type='button'
                    value="Edit"
                    onClick={()=>{handleEditClick()}}
                />
                <input
                    type='button'
                    value="New"
                    onClick={()=>{handleNewClick()}}
                />



            </div>
        )
    }
    
  return postDetailsDisplay
}
