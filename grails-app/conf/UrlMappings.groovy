class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
        "/hinton"(controller:'event', action:'list')
		"/"(controller:'event', action:'list')
		"500"(view:'/error')
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")
	}
}
