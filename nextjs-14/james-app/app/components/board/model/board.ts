export interface IBoards {
    id?: number;
    boardName?: string,
    boardType?: string,
    regDate?: string;
    modDate?: string;
    array?: IBoards[],
    json?: {}
}