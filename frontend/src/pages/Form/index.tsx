import FormCard from 'components/FormCard';
import { Link, useParams } from 'react-router-dom';



function Form() {

    //busca parametro da requisicao
    const params = useParams();

    return (
        <FormCard movieId={`${params.movieId}`} />
    );
}

export default Form;