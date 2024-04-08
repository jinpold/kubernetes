'use client'
import { useState, useEffect } from "react"
import { useSelector, useDispatch } from 'react-redux';
import { NextPage } from "next";
import { getAllArticles } from "@/app/components/article/service/article-slice";
import { fetchAllArticles } from "@/app/components/article/service/article-service";
import { DataGrid } from "@mui/x-data-grid";
import { Box } from "@mui/material";
import ArticleColumns from "@/app/components/article/module/article-columns";

// import React from "react";


// 리액트 - 리덕스는 실행순서가 하향식이 아니다. -> 즉시실행함수부터 먼저 실행됨.
// 하기 page는 .tsx이다. return은 jsx로 와야한다.
const ArtilcesPage: NextPage = ({data}:any) => {
    const dispatch = useDispatch()
    // const [articles, setArticles] = useState([])
    const allArticles: [] = useSelector(getAllArticles) // 4번 실행 (리덕스 통해서 실행가능)

    if(allArticles !== undefined){
        console.log('allArticles is not undefined')

        console.log('length is '+ allArticles.length)
        for(let i=0; i< allArticles.length; i++){
            console.log(JSON.stringify(allArticles[i]))
        }
    }else{
        console.log('allArticles is undefined')
    }
 
    useEffect(() => { // 1번실행  -> 즉시실행 함수 
        dispatch(fetchAllArticles(1))  // dispatch 2번실행 // (fetchAllArticles) 3번실행 (리덕스에 실행)
    }, []) // <- [] 안에 dispatch를 넣었다고 가정하고 dispatch(상태)가 바뀌면 useEffect 다시 실행한다.
    
  
    // 하기 리턴은 jsx로 작성해야함.
    return (<> 
        <h2>개인페이지 Article</h2> 
        <Box sx={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={data}
        columns={ArticleColumns()}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
        checkboxSelection
        disableRowSelectionOnClick
      />
    </Box>
    </>)
}

export default ArtilcesPage