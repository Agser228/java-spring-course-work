import Voucher from "../pages/Voucher"
import Children from "../pages/Children"
import Squads from "../pages/Squads"
import Applications from "../pages/Applications"
import React from "react"

export const routes = [
    {path: '/voucher', component: <Voucher/>, name: "Отправить путевку"},
    {path: '/applications', component: <Applications/>, name: "Заявки"},
    {path: '/children', component: <Children/>, name: "Дети"},
    {path: '/squads', component: <Squads/>, name: "Отряды"},
    {path: '/employee', component: <Squads/>, name: "Работники"},
]
