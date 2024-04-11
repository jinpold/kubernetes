import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./article-init";
import { findAllArticles, findArticleById } from "./article-service";

const articleThunks = [findAllArticles]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handlePending = (state:any) => {
}

const handleRejected = (state:any) => {
}

// const handleFulfilled = (state:any, {payload}:any)=>{   // payload = 자바에 갔다온다 ex) 택배
//     console.log('---------------- conclusion ----------------')
//     state.array = payload
//     console.log(state.array)  
// }  // 하단의 extraReducers:builder에 줄여서 적용시킴 35,36번줄



export const articleSlice = createSlice({   // 슬라이스의 이름 = articles, 슬라이스의 키  = article (리듀서에 있음)
    name: "articles",
    initialState,
    reducers: {}, // reducers 내부 
    extraReducers:builder =>{ // extraReducers 외부
        const {pending, rejected} = status;

        builder                                      // 빌더인데 하나에만 반응한다 = 자바의 switch case와 유사
        .addCase(findAllArticles.fulfilled, (state:any, {payload}:any)=>{state.array = payload}) 
        .addCase(findArticleById.fulfilled, (state:any, {payload}:any)=>{state.json = payload})   
                                                     // = fetchAllArticles.fulfilled이면 handleFulfilled를 실행하라
    }                                                // fetchAllArticles = thunk, fulfilled = 성공
})

export const getAllArticles = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.article.array))
    return state.article.array;  // 이 코드의 article은 리듀서에서 온다 = 리듀서에서 꺼내서 주는 것
}

export const getArticleById = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.article.json))
    console.log("값 불러오기")
    return state.article.json; 

}

export const {} = articleSlice.actions

export default articleSlice.reducer; // 여러개의 리듀서를 합치는 문법 (마지막은 리턴값은 단수형)