import React from 'react'
import Post from './Post'

const Posts = ({posts}) => {

  return (
    <div style={{gap:'30px', margin:'30px', display:'grid', gridTemplateColumns:`repeat(${posts.length}, 1fr)`}}>
        {posts.map(p=>(
        <div style={{gap:'10px', padding:'10px', backgroundColor:'lightpink', display:'flex', flexDirection:'column', alignItems:'center', justifyContent:'center'}}> 
            <div>{p.Id}</div>
            <div>{p.Title}</div>
            <div>{p.Author}</div>
        <button>Post</button>
    </div>))}

    </div>
  )


//   return (
//     <div style={{marginTop:'30px', display:'grid', gridTemplateColumns:'repeat(${posts.length}, 1fr)'}}>
//         {posts.map(p=>(<div>
//             <Post post={p}/>
//         </div>))}

//     </div>
//   )
}

export default Posts