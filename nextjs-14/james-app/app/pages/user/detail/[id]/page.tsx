'use client'
import { NextPage } from "next";
import { DataGrid } from "@mui/x-data-grid"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"
import { useEffect, useState } from "react";
import { Button, Typography } from "@mui/material";
import { findDeleteById, findModify, findUserById } from "@/app/components/user/service/user-service";
import { getDeleteById, getModify, getUserById } from "@/app/components/user/service/user-slice";
import { IUsers } from "@/app/components/user/model/user";
import axios from "axios";
import AxiosConfig from "@/app/components/common/configs/axios-config";
import { PG } from "@/app/components/common/enums/PG";
import { useRouter } from "next/navigation";

export default function userDetailPage (props:any){

  const [inputs, setInputs] = useState({
    password: "",
    phone: "",
    job: "",
  })

  const {password, phone, job } = inputs;
  const handleChange = (e: any) => {
    const { value, name } = e.target;
    setInputs({
        ...inputs,
        [name]: value
      })
  }

  const router = useRouter();
  const handleModify = (e:any) => {
    e.preventDefault()
    const url = `${process.env.NEXT_PUBLIC_API_URL}/users/modify`
    const id = props.params.id
    const data = { id, password, phone, job} 
    const config = AxiosConfig()
    axios.put(url, data, config)
      .then(res => {alert(JSON.stringify(res.data))})
      router.replace(`${PG.USER}/list`)
      dispatch(findModify(data))
  }

  const handleDelete = () => {
    const url = `${process.env.NEXT_PUBLIC_API_URL}/users/delete/${props.params.id}`
    const config = AxiosConfig()
    axios.delete(url, config).then(res => {alert(JSON.stringify(res.data))})
  }

  
  const dispatch = useDispatch()
    const user:IUsers = useSelector(getUserById)
    const deleteUser = useSelector(getDeleteById)
    const modifyUser = useSelector(getModify)
    
    
      useEffect(()=>{
        dispatch(findUserById(props.params.id))
  },[dispatch])

  
  return(<>
      <h3>게시판 상세</h3>
      <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{props.params.id}</Typography>
      <span>아이디 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.username}</Typography>
      <span>비밀번호 : </span><input type="password" placeholder={user.password} name="password" onChange={handleChange} value={password} required /><br /><br />
      <span>이름 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.name}</Typography>
      <span>전화번호 : </span><input type="text" placeholder={user.phone} name="phone" onChange={handleChange} value={phone} required /><br /><br />
      <span>직업 : </span> <input type="text" placeholder={user.job} name="job" onChange={handleChange} value={job} required /><br /><br />
      <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.regDate}</Typography>
      <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.modDate}</Typography>
      <Button onClick={handleModify}>Update</Button>
      <Button onClick={handleDelete}>delete</Button>
      </>)
}