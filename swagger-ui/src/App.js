import React, {useEffect, useState} from 'react';

import SwaggerUI from "swagger-ui-react";
import "swagger-ui-react/swagger-ui.css";
import axios from "axios";

const ServiceList = [
    {
        name: "My Collection",
        url: "http://localhost:8080/v3/api-docs"
    }
];

const App = () => {

    const [spec, setSpec] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(() => {

        const callAPI = async () => {

            setLoading(true);

            try {
                const res = await axios.get(ServiceList[0].url);

                // const res1 = await axios.get("http://localhost:8080/employees", {headers: {Authorization: "Bearer 1231", "api-key": "123"}});

                setSpec(res.data);
                setLoading(false);
            } catch (err) {
                setLoading(false);
                console.error(err);
            }
        }

        callAPI();

    }, [])

    return (
        loading ? "loading..." :
            <>
                {spec ? <SwaggerUI spec={spec}/> : "No data."}
            </>
    )
}

export default App;
