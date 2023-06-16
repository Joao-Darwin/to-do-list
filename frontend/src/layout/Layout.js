import React, { useState } from "react";
import SideBar from "../components/SideBar/SideBar";
import TopBar from "../components/TopBar/TopBar";

const Layout = () => {
    const [sideBarView, setSideBarView] = useState(false);

    const handleSideBarView = () => {
        if (sideBarView) {
            setSideBarView(false);
        } else {
            setSideBarView(true);
        }
    }
    return (
        <>
            {sideBarView && <SideBar handleSideBar={handleSideBarView} />}
            <TopBar handleSideBar={handleSideBarView} />
        </>
    )
}

export default Layout;