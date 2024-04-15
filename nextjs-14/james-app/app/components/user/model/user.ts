export interface IUsers {
    id?: number,
    username?: string,
    password?: string,
    name?: string,
    phone?: string,
    job?: string,
    count?: number,
    message?:string,
    regDate?: string;
    modDate?: string;
    array?:IUsers[],
    json?:{}
    
}