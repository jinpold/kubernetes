export interface IArticles {
    id?: number,
    title?: string,
    content?: string,
    writerId?: number,
    boardId?: number,
    count?: number,
    regDate?: string;
    modDate?: string;
    array?: IArticles[],
    json?: {}
}