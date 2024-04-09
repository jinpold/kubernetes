import { createAsyncThunk } from "@reduxjs/toolkit";
import { findAllBoardsAPI, findBoardByIdAPI } from "./board-api";

export const findAllBoards: any = createAsyncThunk( // 데이터를 비동기로 만들어 자바와 주고 받으려고,
    'boards/findAllBoards',                        // createAsyncThunk가 없으면 동기로 보내는 것
    async (page: number) => {
        console.log('findAllBoards page : ' + page)
        const data: any = await findAllBoardsAPI(1); // axios = 자바와 연결해주는 것

        const { message, result }: any = data;
        // console.log('----- API를 사용한 경우 ------')
        // console.log('message : ' + message)
        // console.log(JSON.stringify(result))
        
        return data
    }
)

export const findBoardById: any = createAsyncThunk( 
    'boards/findBoardById',                      
    async (page: number) => {
        console.log('findBoardById page : ' + page)
        const data: any = await findBoardByIdAPI(page); 

        const { message, result }: any = data;
       
        return data
    }
)