//THIS IS A GENERATED FILE, DO NOT MODIFY;

//This is only to avoid an error in case no endpoint was generated or exported;
export const useless = 0;


const CONTROLLER_BASE_ENDPOINT = '/api/auth';


export async function createAuth(auth : number):Promise<number | null>
    {
        const obj = {auth};
        const response = await fetch(`${CONTROLLER_BASE_ENDPOINT}`,{
            
        method : 'POST',
        mode : 'cors'
        ,body : JSON.stringify(obj)
        });

        if(response.ok){
            return response.json();
        }
        return null;
    }

export async function getAllAuths():Promise<number[] | null | null>
    {
        const obj = {};
        const response = await fetch(`${CONTROLLER_BASE_ENDPOINT}`,{
            
        method : 'GET',
        mode : 'cors'
        
        });

        if(response.ok){
            return response.json();
        }
        return null;
    }

export async function getAuthById(id : number):Promise<number | null>
    {
        const obj = {id};
        const response = await fetch(`${CONTROLLER_BASE_ENDPOINT}/${id}`,{
            
        method : 'GET',
        mode : 'cors'
        
        });

        if(response.ok){
            return response.json();
        }
        return null;
    }

export async function updateAuth(id : number,newAuth : number):Promise<number | null>
    {
        const obj = {id,newAuth};
        const response = await fetch(`${CONTROLLER_BASE_ENDPOINT}/${id}`,{
            
        method : 'PUT',
        mode : 'cors'
        ,body : JSON.stringify(obj)
        });

        if(response.ok){
            return response.json();
        }
        return null;
    }

export async function deleteAuth(id : number):Promise<void | null>
    {
        const obj = {id};
        const response = await fetch(`${CONTROLLER_BASE_ENDPOINT}/${id}`,{
            
        method : 'DELETE',
        mode : 'cors'
        ,body : JSON.stringify(obj)
        });

        if(response.ok){
            return response.json();
        }
        return null;
    }

interface AuthModels{
        
    }