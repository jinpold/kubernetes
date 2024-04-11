'use client'
import { NextPage } from "next";
import { DataGrid } from "@mui/x-data-grid"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"
import { useEffect } from "react";
import { Typography } from "@mui/material";
import { findUserById } from "@/app/components/user/service/user-service";
import { getUserById } from "@/app/components/user/service/user-slice";

export default function userDetailPage (props:any){

    const dispatch = useDispatch()
    const user = useSelector(getUserById)
    
    useEffect(()=>{
        dispatch(findUserById(props.params.id))
    },[])


    return(<>
    <h3>게시판 상세</h3>
    <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{props.params.id}</Typography>
    <span>아이디 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.username}</Typography>
    <span>비밀번호 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.password}</Typography>
    <span>이름 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.name}</Typography>
    <span>전화번호 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.phone}</Typography>
    <span>직업 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.job}</Typography>
    <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.regDate}</Typography>
    <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.modDate}</Typography>
    </>)
}