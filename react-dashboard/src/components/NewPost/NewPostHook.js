import axios from "axios";
import { fetchService } from "../../services/fetchServices";
import { useState, useRef, useEffect} from "react";


const NewPostHook = (props) =>{
    const newPostForm = useRef();
    
    const PostHandler = () =>{
        const form = newPostForm.current;
        const data = {
            title: form['title'].value,
            content: form['content'].value,
            author: form['author'].value
        };
        console.log(data);
        fetchService.post("", data);
        props.click();
    }

    return(
        <div>
            <form ref={newPostForm}>
                <h3>Add a Post</h3>
                <label>Title</label>
                <input type="text"
                    label={'title'}
                    name={'title'}
                />

                <label>Content</label>
                <input type="text"
                    label={'content'}
                    name={'content'}

                />
                <label>Author</label>
                <input type="text"
                    label={'author'}
                    name={'author'}
                />

            </form>
            <button onClick={PostHandler}>Add Post</button>
        </div>
    )

}
export default NewPostHook;