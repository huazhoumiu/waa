import React from 'react'
import { Navigate, Route, Routes } from 'react-router'
import { Posts } from '../Posts/Posts'
import NewPost from '../../components/NewPost/NewPost'
import { PostDetails } from '../../components/PostDetails/PostDetails'
import EditPost from '../../components/EditPost/EditPost'
import Homepage from './Homepage'
import { Missing } from './Missing'
import Post from '../../components/Post/Post'


export default function PageRoutes () {
  return (
    <Routes>
        {/* <Route path="/" element={<Navigate replace to = "/posts" />} /> */}
        <Route path='/' element={<Homepage />} />
        <Route path='/posts' element={<Post />}/>
        {/* </Route> */}
        <Route path="new-post" element={<NewPost />}/>
        <Route path="edit-post/:id" element={<EditPost />}/>
        <Route path="*" element={<Missing/>}/>
    </Routes>
  )
}
