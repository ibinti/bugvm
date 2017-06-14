//
//  NativeLibrary.hpp
//
//

#ifndef NativeLibrary_hpp
#define NativeLibrary_hpp

#include <string>

namespace NativeLibrary {
    class NativeClass {
    public:
        const std::string& get_property() { return property; }
        void set_property(const std::string& property) { this->property = property; }
        std::string property;
    };
}

#endif /* NativeLibrary_hpp */
