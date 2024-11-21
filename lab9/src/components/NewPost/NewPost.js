import React from 'react'
import { useNavigate } from 'react-router';
import { useRef } from 'react';
import axios from 'axios';

const NewPost = () => {

    const newPostForm = useRef();
    const navigate = useNavigate();

    const PostHandler = (e) =>{
        e.preventDefault();
        const form = newPostForm.current;
        const data = {
            title: form['title'].value,
            content: form['content'].value,
            author: form['author'].value
        }

        axios.post('http://localhost:8080/api/v1/posts', data)
            .then(data=>{
                navigate('/posts')
            })
            .catch(err =>console.log(err.message))
    }

  return (
    <div className='NewPost'>
        With Ref
        <form ref={newPostForm} onSubmit={PostHandler}>
            <h1>Add a Post</h1>
            <label>Title</label>
            <input type="text"
                labe={'title'}
                name={'title'}
            />
            <lable>Content</lable>
            <input type="text"
                labe={'content'}
                name={'content'}
            />
            <lable>Author</lable>
            <input type="text"
                labe={'author'}
                name={'author'}
            />
            <button onClick={PostHandler}>Add Post</button>
        </form>
    </div>
  )
}

export default NewPost