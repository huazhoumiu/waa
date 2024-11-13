import React from 'react'
import Post from '../../components/Post/Post'


const Posts = (props) => {

    
  const posts = props.posts.map(post => {
      
      return <Post
          title={post.title}
          content={post.content}
          author={post.author}
          id={post.id}
          key={post.id}
          deletePost={() => { props.deletePost(post.id) }}
          setSelected={()=> { props.setSelected(post.id) }}
      />
  });
  return posts;

}




// const Posts = ({props}) => {
  // const posts = props.posts.map(post=>{
    
  //     return<Post
  //       key = {posts.id}
  //       title = {post.title}
  //       content = {post.content}
  //       author = {post.author}
  //       setSelected = {()=>props.setSelected}

  //     />
    
  // });
  // return posts;

  // return props.posts.map((post) => (
  //   <Post
  //     key={post.id}
  //     post={post}  // Passing the whole post object
  //     setSelected={props.setSelected}  // Passing setSelected function
  //   />
  // ));

// }

//   return (
//     <div style={{gap:'30px', margin:'30px', display:'grid', gridTemplateColumns:`repeat(${posts.length}, 1fr)`}}>
//         {posts.map(p=>(<div>
//           <Post props={p}/>
//         </div>))}
//     </div>
//   )
// }

export default Posts