import React, { useState } from 'react'
import Posts from './Posts'

const Dashboard = () => {
    const [posts, setPosts] = useState([
        { Id: 111, Title: "Happiness", Author: "John" },
        { Id: 112, Title: "MIU", Author: "Dean" },
        { Id: 113, Title: "Enjoy Life", Author: "Jasmine" }
    ])

    const [title, setTitle] = useState('');

    const handleSubmit = () =>{
        const updatePosts = [...posts];
        updatePosts[0].Title = title;
        setPosts(updatePosts);
        setTitle('');
    }

  return (
    <div>
        <Posts posts = {posts}/>
        <input type='text' value={title} onChange={(e)=> setTitle(e.target.value)} placeholder='Enter new title' style={{marginLeft:'30px'}}/>
        <button onClick={handleSubmit}>Submit</button>
    </div>
  )
}

export default Dashboard