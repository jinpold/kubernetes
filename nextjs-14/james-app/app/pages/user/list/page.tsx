'use client'
import UserColumns from "@/app/components/user/module/user-column"
import { IUsers } from "@/app/components/user/model/user-model"
import { fetchAllUsers } from "@/app/components/user/service/user-service"
import { getAllUsers } from "@/app/components/user/service/user-slice"
import { DataGrid } from "@mui/x-data-grid"
import { NextPage } from "next"
import { useEffect, useState } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

const UsersPage: NextPage = () => {
    const [pageSize, setPageSize] = useState(5); // 4-1

    const dispatch = useDispatch()
    const allUsers: [] = useSelector(getAllUsers)

    if(allUsers !== undefined){
        console.log('allUsers is not undefined')

        console.log('length is ' + allUsers.length)
        for(let i=0; i<allUsers.length; i++){
            console.log(JSON.stringify(allUsers[i]))
        }
    }else{
        console.log('allUsers is undefined')
    }

    useEffect(()=>{
        dispatch(fetchAllUsers(1))
    },[])

    return(<>
    <div style={{ height: 400, width: "100%" }}>
      <DataGrid // 🔥 4
        rows={allUsers}
        columns={UserColumns()}
        pageSizeOptions={[5, 10, 20]} // 4-1
        checkboxSelection
      />
    </div></>)
}

export default UsersPage