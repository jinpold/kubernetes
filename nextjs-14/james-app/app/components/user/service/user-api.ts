import { instance } from "@/app/components/common/configs/axios-config"
import { IUsers } from "../model/user"

export const findAllUsersAPI = async (page: number) => {
    try{
        const response = await instance.get('/users/list',{
            params: {page, size:10, limit: 10}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
    
}

export const findUserByIdAPI = async (id: number) => {
    try{
        const response = await instance.get('/users/detail',{
            params: {id}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
    
}

export const findModifyAPI = async (modify: IUsers) => {
    try{
        const response = await instance.put('/users/modify',{
            params: {modify}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
    
}

export const findDeleteByIdAPI = async (deleteId: IUsers) => {
    try{
        const response = await instance.delete('/users/delete',{
            params: {deleteId}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
    
}