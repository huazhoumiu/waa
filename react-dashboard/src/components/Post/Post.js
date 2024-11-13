import React from 'react'

const Post = (props) => {
  return (
    <div className="Content">
        {/* <div>{post.id}</div> */}
        <h3>{props.title}</h3>
        <div className='Field'>
          {props.content}
        </div>
          {props.author}
        <div className='Edit'>
          <input 
            type="button"
            value="Delete"
            onClick={props.deletePost}
          />
        </div>
    </div>
  )
}





export default Post