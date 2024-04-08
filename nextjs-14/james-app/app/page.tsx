'use client';
import { useState } from "react";
import axios from 'axios'
import Link from "next/link";
import { Box, Button, Input } from '@mui/material';
import { PG } from "./components/common/enums/PG";
import AxiosConfig from "./components/common/configs/axios-config";
import { useRouter } from "next/navigation";

export default function Home() {  // Home() = 컴포넌트 = 펑션

  const [name, setName] = useState('')
  const router = useRouter();
  const handleChange = (e:any) =>{setName(e.target.value)} // any는 자바의 ? 와일드카드
  const handleClick = ()=>{
    alert('request가 가져가는 이름 : '+ name )
  const url = `${process.env.NEXT_PUBLIC_API_URL}/name` // 자바의 "%s", sql의 '고%' 와 같다
  const data = {'name' : name} // 키에는 스트링만 가능 ''생략가능
  const config = AxiosConfig()

  axios.post(url,data,config)
  .then(res=>{
    alert(JSON.stringify(res.data))
  })}

  return(
  <></>);
}
