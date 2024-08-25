//THIS IS A GENERATED FILE, DO NOT MODIFY;

//This is only to avoid an error in case no endpoint was generated or exported;
export const useless = 0;
const SERVER_URL = 'http://localhost:8080';


const CONTROLLER_BASE_ENDPOINT = '/api/metadata';


export async function getApiStructure():Promise<string | null>
    {
        const obj = {};
        const response = await fetch(`${SERVER_URL}${CONTROLLER_BASE_ENDPOINT}/describe`,{
            
        method : 'GET',
        mode : 'cors'
        
        });

        if(response.ok){
            return response.json();
        }
        return null;
    }

