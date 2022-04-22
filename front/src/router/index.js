import React from "react"
import Applications from "../pages/Applications"
import Children from "../pages/Children"
import Squads from "../pages/Squads"
import Voucher from "../pages/Voucher"
import Shifts from './../pages/Shifts'
import Workers from './../pages/Workers'

export const adminRoutes = [
    {path: '/shifts', component: <Shifts/>, name: "Смены"},
    {path: '/applications', component: <Applications/>, name: "Заявки"},
    {path: '/children', component: <Children editable={true}/>, name: "Дети"},
    {path: '/squads', component: <Squads/>, name: "Отряды"},
    {path: '/workers', component: <Workers/>, name: "Работники"},
]
export const parentRoutes = [
    {path: '/voucher', component: <Voucher/>, name: "Отправить путевку"},
    {path: '/squads', component: <Squads/>, name: "Отряды"},
]


export const workerRoutes = [
    {path: '/children', component: <Children editable={false}/>, name: "Дети"},
    {path: '/squads', component: <Squads/>, name: "Отряды"},
]

export const routes = {
    "ADMIN" : adminRoutes,
    "PARENT": parentRoutes,
    "WORKER": workerRoutes,
    "all": []
}
