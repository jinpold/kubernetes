'use client'
import { NextPage } from "next";
import { useEffect } from "react";
import UserColumns from "@/app/components/user/module/user-column"
import { IUsers } from "@/app/components/user/model/user"
import { findAllUsers } from "@/app/components/user/service/user-service"
import { getAllUsers } from "@/app/components/user/service/user-slice"
import { DataGrid } from "@mui/x-data-grid"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"
import { Typography } from "@mui/material";
import { createAsyncThunk } from "@reduxjs/toolkit/react";
import { getBoardById } from "@/app/components/board/service/board-slice";
import { findBoardById } from "@/app/components/board/service/board-service";
import { IBoards } from "@/app/components/board/model/board";


export default function BoardDetailPage (props:any){


    const dispatch = useDispatch()
    const board:IBoards = useSelector(getBoardById)
    
    useEffect(()=>{
        dispatch(findBoardById(props.params.id))
    },[])

    
    return(<>
    
    <h3>게시판 상세</h3>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{props.params.id}</Typography>
    <span>게시판이름 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{board.boardName}</Typography>
    <span>게시판타입 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{board.boardType}</Typography>
    <span>동록일 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{board.regDate}</Typography>
    <span>수정일 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{board.modDate}</Typography>

    </>)
}
