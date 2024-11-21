import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import Post from '../../components/Post/Post';
import { PostDetails } from '../../components/PostDetails/PostDetails';

export const Posts = () => {

  const [postsState, setPostStates] = useState([{}]);

  const fetchPosts = () =>{
    axios.get('http://localhost:8080/api/v1/posts')
        .then(response => {
          setPostStates(response.data)
        })
        .catch(error => {
          console.log(error.message)
        })
  }

  useEffect(() => {
    fetchPosts()
  },[])

  const posts = postsState.map(post=>{
    return(
      <Link to={`${post.id}`} key={post.id}>
        <Post 
          title={post.title}
          content={post.title}
          author={post.author}
          id={post.id}
          key={post.id}
        />
      </Link>
    )
  })

  return (
    <div className='Post'>
      {posts}
      {/* <PostDetails /> */}
    </div>
  )
}

export default Posts;
