import React from 'react'

export const Post = (props) => {
  return (
    <div className='Content'>
        <h3>{props.title}</h3>
        <div className='Field'>
            {props.content}
        </div>
        {props.author}
    </div>
  )
}

export default Post;