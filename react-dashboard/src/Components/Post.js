import React from 'react'

function Post({post}) {
  return (
    <div style={{padding:'10px', backgroundColor:'lightpink', display:'flex', flexDirection:'column', alignItems:'center', justifyContent:'center'}}>
        <div>{post.Id}</div>
        <div>{post.Title}</div>
        <div>{post.Author}</div>
        <button>Post</button>
    </div>
  )
}

export default Post