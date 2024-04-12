'use client'
import BoardColumns from "@/app/components/board/module/board-columns"
import { findAllBoards, findCount } from "@/app/components/board/service/board-service"
import { getAllBoards, getCount } from "@/app/components/board/service/board-slice"
import { StyledDataGrid } from "@/app/components/common/style/board"
import { DataGrid } from "@mui/x-data-grid"
import { NextPage } from "next"
import { useEffect, useState } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"

const BoardsPage: NextPage = () => {
    const [pageSize, setPageSize] = useState(5); 
    

    const dispatch = useDispatch()
    const allBoards: [] = useSelector(getAllBoards)
    const countBoards = useSelector(getCount)

    if(allBoards !== undefined){
        console.log('allboards is not undefined')

        console.log('length is ' + allBoards.length)
        for(let i=0; i<allBoards.length; i++){
            console.log(JSON.stringify(allBoards[i]))
        }
    }else{
        console.log('allBoards is undefined')
    }

    useEffect(()=>{
        dispatch(findAllBoards(1))
        dispatch(findCount())
    },[])

    return(<>
    <h2> 게시판 수 :{countBoards} </h2>
    <div style={{ height: "100%", width: "100%" }}>
      {allBoards && <DataGrid //DataGrid
        rows={allBoards}
        columns={BoardColumns()}
        initialState={{
            pagination: {
              paginationModel: {
                pageSize: 5,
              },
            },
          }}
        pageSizeOptions={[5, 10, 20]} 
        checkboxSelection
      />}
    </div></>)
}

export default BoardsPage