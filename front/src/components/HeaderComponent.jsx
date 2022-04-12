import React from 'react';

const HeaderComponent = () => {
    return (
        <div>
        <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
            <div>
                <a href="/" className='navbar-brand'>
                    Лагерь
                </a>
            </div>
            <div className='nav-item'><a className="nav-link active text-light" href="/voucher">Заполнение путевок</a></div>
            <div className='nav-item'><a className="nav-link active text-light" href="/db-change">Изменение в базе</a></div>
            <div className='nav-item'><a className="nav-link active text-light" href="/workforce">Кадры</a></div>
            <div className='nav-item'><a className="nav-link active text-light" href="/squads">Отряды</a></div>
            <div className='nav-item'><a className="nav-link active text-light" href="/children">Дети</a></div>
        </nav>
    </div>
    );
};

export default HeaderComponent;