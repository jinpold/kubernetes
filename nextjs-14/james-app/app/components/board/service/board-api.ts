import { instance } from '@/app/components/common/configs/axios-config'

export const findAllBoardsAPI = async (page: number) =>{     // axios = 동기식, 
    try{                                                        // axios를 thunk로 감싸면 비동기가 된다
        const response = await instance.get('/boards/list',{
            params: {page, size:10, limit: 10}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
    
}