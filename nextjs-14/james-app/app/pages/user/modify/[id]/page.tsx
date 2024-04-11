// 'use client';
// import { useRouter } from "next/navigation"
// import { useEffect, useState } from "react";
// import axios from 'axios'
// import React from 'react';
// import AxiosConfig from "@/app/components/common/configs/axios-config";
// import { PG } from "@/app/components/common/enums/PG";
// import { NextPage } from "next";
// import { useDispatch, useSelector } from "react-redux";
// import { findModify, findUserById } from "@/app/components/user/service/user-service";
// import { IUsers } from "@/app/components/user/model/user";
// import { getModify, getUserById } from "@/app/components/user/service/user-slice";
// import { Button, Typography } from "@mui/material";


// export default function userModifyPage (props:any) {

//     const [inputs, setInputs] = useState({
//       password: "",
//       phone: "",
//       job: "",
//     })

//     const {password, phone, job } = inputs;
//     const handleChange = (e: any) => {
//       const { value, name } = e.target;
//       setInputs({
//           ...inputs,
//           [name]: value
//         })
//     }
//     const router = useRouter();

//     const handleSubmit = (e:any) => {
//       e.preventDefault()
//       const url = `${process.env.NEXT_PUBLIC_API_URL}/users/save`
//       const data = { password, phone, job} 
//       const config = AxiosConfig()
//       axios.post(url, data, config)
//         .then(res => {
//           alert(JSON.stringify(res.data))
//           router.push(`${PG.USER}/list`)
//         })
//     }

//     const dispatch = useDispatch()
//     const modifyUser = useSelector(getModify)
//     const user:IUsers = useSelector(getUserById)


//       useEffect(()=>{
//         dispatch(findUserById(props.params.id))
//         dispatch(findModify(props.params.id))
//     },[])
  
  
//     return(<>
//       <h3>게시판 상세</h3>
//       <span>ID : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{props.params.id}</Typography>
//       <span>아이디 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.username}</Typography>
//       <span>비밀번호 : </span><input type="password" placeholder="Enter Password" name="password" onChange={handleChange} value={password} required />
//       <span>이름 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.name}</Typography>
//       <span>전화번호 : </span><input type="text" placeholder="Enter Phone Number" name="phone" onChange={handleChange} value={phone} required />
//       <span>직업 : </span> <input type="text" placeholder="Enter Job" name="job" onChange={handleChange} value={job} required />
//       <span>작성일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.regDate}</Typography>
//       <span>수정일자 : </span><Typography textAlign="center" sx={{fontSize:"1.2rem"}}>{user.modDate}</Typography>
//       <Button onClick={handleSubmit}>Update</Button>
//       <Button onClick={handleSubmit}>delete</Button>
//       </>)
//   }

