import {API} from '../config/api'
import axios from 'axios'

const get = async (url) => {
    try{
        let data = [];
        data = (await API.get(url)).data;
        return data;
    }catch(error){
        console.log(error.message)
        return[];
    }
}

const post = async (url, data) => {
    try {
        let result = [];
        result = await API.post(url, data);
        return result;
    } catch (error) {
        console.log(error.message);
        return[];        
    }
}

export const fetchService = {
    get,
    post
}