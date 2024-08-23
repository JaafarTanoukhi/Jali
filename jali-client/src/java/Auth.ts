const obj = {

}
 interface login{
    name : string
    something : number
    go : []
    map : {}
    val : boolean
 }



export async function login(){
    return await fetch('local', {
        method : 'post',
        mode: 'cors'
    })
}