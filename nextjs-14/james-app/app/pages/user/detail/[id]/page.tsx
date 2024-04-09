'use client'
import { NextPage } from "next";

export default function userDetailPage (props:any){
    return(<>
    No {props.params.id} <br /> 게시판 상세
    </>)
}