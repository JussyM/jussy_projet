cmake_minimum_required(VERSION 3.19)
project(53554_bonne_nuit)
set(CMAKE_CXX_STANDARD 17)

if (UNIX AND NOT APPLE)
    set(CMAKE_PREFIX_PATH "$ENV{HOME}/Qt/6.1.2/gcc_64/lib/cmake")
endif (UNIX AND NOT APPLE)
if (MSVC OR MSYS OR MINGW)
    set(CMAKE_PREFIX_PATH "C:\\Qt\\6.1.2\\mingw81_64\\lib\\cmake\\")
endif (MSVC OR MSYS OR MINGW)
set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTORCC ON)
set(CMAKE_AUTOUIC ON)

set(QT_VERSION 6)
set(REQUIRED_LIBS Core Gui Widgets)
set(REQUIRED_LIBS_QUALIFIED Qt6::Core Qt6::Gui Qt6::Widgets)

add_executable(${PROJECT_NAME} main/main.cpp
        model/Board.cpp model/Board.h model/Game.cpp model/Game.h model/position.cpp
        model/position.h d_pattern/observer.hpp
        d_pattern/Observable.hpp model/Pawn.cpp
        model/Pawn.h model/square.cpp model/square.h model/square.cpp
        model/Color.h model/Player.cpp model/Player.h
        model/random.hpp model/dew_drop.cpp model/dew_drop.h
        view/bn_gui.h
        view/bn_gui.cpp view/bn_gui.h view/bn_gui.ui resources/bn_img.qrc
        view/square_view.cpp view/square_view.h app/bn_application.cpp app/bn_application.h)

if (NOT CMAKE_PREFIX_PATH)
    message(WARNING "CMAKE_PREFIX_PATH is not defined, you may need to set it "
            "(-DCMAKE_PREFIX_PATH=\"path/to/Qt/lib/cmake\" or
            -DCMAKE_PREFIX_PATH=/usr/include/{host}/qt{version}/ on Ubuntu)")
endif ()

find_package(Qt${QT_VERSION} COMPONENTS ${REQUIRED_LIBS} REQUIRED)
target_link_libraries(${PROJECT_NAME} ${REQUIRED_LIBS_QUALIFIED})
