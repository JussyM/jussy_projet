//
// Created by justu on 18-09-21.
//

#ifndef INC_53554_BONNE_NUIT_OBSERVABLE_HPP
#define INC_53554_BONNE_NUIT_OBSERVABLE_HPP

#include "observer.hpp"

class observable {
    /**
     * @brief Register an observer
     * @param observer the observer object to be registered
     */
    virtual void register_observer(observer *observer) = 0;

    /**
     *@brief Notify all the registered observers when a change happens
     * @param Observable the subject that notify the observer
     */
    virtual void notify_observers(observable *) = 0;
};


#endif //INC_53554_BONNE_NUIT_OBSERVABLE_HPP
