import React from 'react'
import { Link } from 'react-router-dom'

export const Homepage = () => {
  return (
    <div>Homepage

        <ul className='list'>
            <li class="i-one"><Link to="posts">Posts</Link></li>
            <li class="i-two"><Link to="new-post">New Posts</Link></li>
        </ul>
    </div>
  )
}

export default Homepage
