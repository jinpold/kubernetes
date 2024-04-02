export interface IArticle { // (리액트) grid <-> table (DB) 일치시키게 코딩해야한다.
    id: number,
    title: string,
    content: string,
    writer: number,
    registerDate: string,
    array: []
}