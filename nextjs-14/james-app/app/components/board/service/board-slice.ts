import { createSlice } from "@reduxjs/toolkit";
import { findAllBoards, findBoardById } from "./board-service";
import { initialState } from "./board-init";



const boardThunks = [findAllBoards]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handlePending = (state:any) => {
}


const handleRejected = (state:any) => {
}



export const boardSlice = createSlice({  
    name: "boards",
    initialState,
    reducers: {},
    extraReducers:builder =>{
        const {pending, rejected} = status;

        builder                                                 
        .addCase(findAllBoards.fulfilled, (state:any, {payload}:any)=>{state.array = payload})  
        .addCase(findBoardById.fulfilled, (state:any, {payload}:any)=>{state.json = payload}) 
    }                                                        
})

export const getAllBoards = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.board.array))
    return state.board.array;  
}

export const getBoardById = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.board.json))
    console.log("값 불러오기")
    return state.board.json; 

}


export const {} = boardSlice.actions

export default boardSlice.reducer;