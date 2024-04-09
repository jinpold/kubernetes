import { NextPage } from "next";

export default function BoardDetailPage (props:any){
    return(<>
        No {props.params.id} <br /> 게시판 상세
        </>)
}