'use client'
import { findArticleById } from "@/app/components/article/service/article-service";
import { getArticleById } from "@/app/components/article/service/article-slice";
import { Typography } from "@mui/material";
import { NextPage } from "next";
import { useEffect } from "react";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";

export default function ArticleDetailPage (props:any){

    const dispatch = useDispatch()
    const article = useSelector(getArticleById)
    
    useEffect(()=>{
        dispatch(findArticleById(props.params.id))
    },[])

    return(<>
    <h3>게시판 상세</h3>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{props.params.id}</Typography>
    <span>제목 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{article.title}</Typography>
    <span>내용 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{article.content}</Typography>
    <span>작성자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{article.writerId}</Typography>
    <span>게시글 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{article.boardId}</Typography>
    <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{article.regDate}</Typography>
    <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{article.modDate}</Typography>
    </>)
}