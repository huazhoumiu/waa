import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import Library from '../../components/Library/Library';

export const Libraries = () => {

  const [librariesState, setLibraryState] = useState([{}]);

  const fetchLibraries = () =>{
    axios.get('https://65bd8dd8b51f9b29e9338ba8.mockapi.io/api/v1/libraries')
        .then(response => {
            setLibraryState(response.data)
        })
        .catch(error => {
          console.log(error.message)
        })
  }

  useEffect(() => {
    fetchLibraries()
  },[])

  const libraries = librariesState.map(lib=>{
    return(
      <Link to={`${lib.id}`} key={lib.id}>
        <Library 
          name={lib.name}
          city={lib.city}
          id={lib.id}
          key={lib.id}
        />
      </Link>
    )
  })

  return (
    <div className='Post'>
      {libraries}
    </div>
  )
}

export default Libraries;
