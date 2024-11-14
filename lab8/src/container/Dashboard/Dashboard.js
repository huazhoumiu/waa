import React, { useEffect, useState } from 'react'
import Posts from '../Posts/Posts'
import { fetchService } from '../../services/fetchServices';
import NewPostHook from '../../components/NewPost/NewPostHook';
import axios from 'axios';
import PostDetails from '../../components/PostDetails/PostDetails';
import { SelectIdContext } from '../../context/SelectedId';
// import { response } from 'express';


const Dashboard = () => {
    const [posts, setPosts] = useState([
        { id: 111, title: "Happiness", author: "John" },
        { id: 112, title: "MIU", author: "Dean" },
        { id: 113, title: "Enjoy Life", author: "Jasmine" }
    ])

    const [title, setTitle] = useState('');

    const [selectedState, setSelectedState] = useState(-1);

    const setSelected = (id) => {
      setSelectedState(id);
    }

    const handleSubmit = () =>{
        const updatePosts = [...posts];
        updatePosts[0].title = title;
        setPosts(updatePosts);
        setTitle('');
    }

    const fetchPosts = async() =>{
      const post = await fetchService.get("");
      console.log(post); 
      setPosts(post);
      // setPosts(await fetchService.get(""))
    }

    const [flag, setFlag] = useState(true)

    const flagHandler = () => {
      setFlag(!flag);
    }

    useEffect(()=>{
      fetchPosts()
    },[flag])

    const [postState, setPostState] = useState(
      {
        title:"",
        content:"",
        author:""
      }
    )

    const deleteButtonClicked = (id) => {
      axios.delete('http://localhost:8080/api/v1/posts/' + id)
      .then(response=>{
        fetchPosts();
        flagHandler();
      })
      .catch(err=>{
        console.error(err);
      })
    }

  return (
    <SelectIdContext.Provider value={selectedState}>
      <div>
          <div className="Post">
            <Posts 
              posts = {posts}
              setSelected = {setSelected}
              deletePost= {deleteButtonClicked}
            />
          </div>
          <div>
            <PostDetails />
          </div>
          <input type='text' value={title} onChange={(e)=> setTitle(e.target.value)} placeholder='Enter new title' style={{marginLeft:'30px'}}/>
          <button onClick={handleSubmit}>Submit</button>
          <NewPostHook click = {flagHandler}/>
      </div>
    </SelectIdContext.Provider>
  )
}

export default Dashboard