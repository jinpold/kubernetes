import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./user-init";
import { findAllUsers, findDeleteById, findModify, findUserById } from "./user-service";

const userThunks = [findAllUsers]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected' 
}

const handlePending = (state:any) => {}

const handleRejected = (state:any) => {}

export const userSlice = createSlice({
    name: "users",
    initialState,
    reducers: {},
    extraReducers:builder =>{
        const {pending, rejected} = status;

        builder.addCase(findAllUsers.fulfilled, (state:any, {payload}:any) => {state.array = payload})
        builder.addCase(findUserById.fulfilled, (state:any, {payload}:any) => {state.json = payload})
        builder.addCase(findModify.fulfilled, (state:any, {payload}:any) => {state.array = payload})
        builder.addCase(findDeleteById.fulfilled, (state:any, {payload}:any) => {state.json = payload})
    }
})

export const getAllUsers = (state:any) => {
    console.log('-- Before useSelector --')
    console.log(JSON.stringify(state.user.array))
    return state.user.array;
}

export const getUserById = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.user.json))
    console.log("값 불러오기")
    return state.user.json; 

}

export const getModify = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.user.array))
    console.log("값 불러오기")
    return state.user.array; 

}

export const getDeleteById = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.user.json))
    console.log("값 불러오기")
    return state.user.json; 

}

export const { } = userSlice.actions

export default userSlice.reducer;