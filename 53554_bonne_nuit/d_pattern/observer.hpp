//
// Created by justu on 18-09-21.
//

#ifndef INC_53554_BONNE_NUIT_OBSERVER_HPP
#define INC_53554_BONNE_NUIT_OBSERVER_HPP

class observable;
class observer {

public:

    /**
     * Update the state of this observer
     *  @param Observable the observable that change state
     */
    virtual void update(observable* ) = 0;


};


#endif //INC_53554_BONNE_NUIT_OBSERVER_HPP
