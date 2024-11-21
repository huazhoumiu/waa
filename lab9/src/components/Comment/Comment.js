import React from 'react'

const Comment = React.memo((props) => {
  return (
    <div className='Comment'>
        {props.name}
    </div>
  )
});

export default Comment;
