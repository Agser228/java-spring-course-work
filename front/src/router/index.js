import Voucher from "../pages/Voucher"
import Children from "../pages/Children"
import Squads from "../pages/Squads"

export const routes = [
    {path: '/', component: <Children/>, exact: true},
    {path: '/voucher', component: <Voucher/>, exact: true},
    {path: '/children', component: <Children/>, exact: true},
    {path: '/squads', component: <Squads/>, exact: true},
]
